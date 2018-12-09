package com.qjx.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.StampedLock;

/**
 *
 */
@Slf4j
public class LockExample4 {

    class Point{

        private double x,y;
        private final StampedLock sl = new StampedLock();

        /**
         * an exclusively locked method
         * 独占锁方法
         * @param deltaX
         * @param deltaY
         */
        void move(double deltaX,double deltaY){
            long stamp = sl.writeLock();
            try {
                x+=deltaX;
                y+=deltaY;
            }finally {
                sl.unlockWrite(stamp);
            }
        }

        /**
         * A read-only method
         * 乐观读锁案例
         * @return
         */
        double distanceFromOrigin(){
            //获得一个乐观读锁
            long stamp = sl.tryOptimisticRead();
            //将两个字段读入本地局部变量
            double currentX = x,currentY = y;
            //检查发生乐观读锁后同时是否有其他锁发生
            if(!sl.validate(stamp)){
                //如果没有，我们再此获得一个读悲观锁
                stamp = sl.readLock();
                try {
                    //将两个字段读入本地局部变量
                    currentX = x;
                    currentY = y;
                }finally {
                    sl.unlockRead(stamp);
                }
            }
            return Math.sqrt(currentX * currentX +currentY * currentY);
        }
        /**
         * 下面是悲观读锁案例
         * upgrade
         */
        void moveIfAtOrigin(double newX,double newY){
            // Could instead start with optimistic, not read mode
            long stamp = sl.readLock();

            try {
                //循环检查当前状态是否负荷
                while (x==0.0 && y==0.0){
                    //尝试转换为写锁
                    long ws = sl.tryConvertToWriteLock(stamp);
                    //这个判断是确认转换写锁是否成功
                    if(ws!=0L){
                        //如果成功 替换票据
                        stamp = ws;
                        //进行状态改变
                        x = newX;
                        y = newY;
                        break;
                    }else {
                        //如果不能成功
                        //我们显式的释放读锁
                        sl.unlockRead(stamp);
                        //显式直接进行写锁，然后再进行循环试
                        stamp = sl.writeLock();
                    }

                }

            }finally {
                //释放读锁或者写锁
                sl.unlockRead(stamp);
            }

        }


    }


}
