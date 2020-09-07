import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by qincasin on 2020/7/2.
 */

public final class UpdateDiffer<T> {
    /**
     * 原来的对象
     */
    private final T original;
    /**
     * 要更新的对象
     */
    private final T toUpdate;
    /**
     * ”原来的对象“和“要更新的对象”比较出来用于更新的对象
     */
    private final T difference;
    /**
     * 需要比较的字段的get方法
     */
    private final List<Function<T, ?>> getMethodList;

    /**
     * Initializes a newly created UpdateDiffer object
     *
     * @param original     原来的对象
     * @param toUpdate     要更新的对象
     * @param tConstructor T类型对象构造方法
     */
    public UpdateDiffer(T original, T toUpdate, Supplier<T> tConstructor) {
        Objects.requireNonNull(original);
        Objects.requireNonNull(toUpdate);
        Objects.requireNonNull(tConstructor);
        this.original = original;
        this.toUpdate = toUpdate;
        this.difference = tConstructor.get();
        getMethodList = new ArrayList<>();
    }

    /**
     * 比较字段是否相同，如果不同，把要更新的对象字段值设置到difference对象里
     *
     * @param getMethod get方法
     * @param setMethod set方法
     * @param <R>       get方法的返回值类型/set方法参数类型
     * @return this
     */
    public <R> UpdateDiffer<T> diffing(Function<T, R> getMethod, BiConsumer<T, R> setMethod) {
        Objects.requireNonNull(getMethod);
        Objects.requireNonNull(setMethod);
        R toUpdateValue = getMethod.apply(toUpdate);
        R originalValue = getMethod.apply(original);
        Objects.requireNonNull(originalValue, "数据库中的字段不应该为null");
        if (!originalValue.equals(toUpdateValue)) {
            setMethod.accept(difference, toUpdateValue);
        }
        // 保存已经调用的get方法
        getMethodList.add(getMethod);
        return this;
    }

    /**
     * 获取”原来的对象“和“要更新的对象”比较出来的对象，用于去数据库更新（更新前还要再设置id等字段）。
     *
     * @return ”原来的对象“和“要更新的对象”比较出来用于更新的对象。如果“原来的对象”和“要更新的对象”中所有要比较的字段都相同，返回null
     */
    public T diff() {
        // 如果difference对象中所有要比较的字段都为null
        if (
                getMethodList.stream()
                        .map(getFunction -> getFunction.apply(difference))
                        .allMatch(Objects::isNull)
        ) {
            return null;
        }
        return this.difference;
    }
}
