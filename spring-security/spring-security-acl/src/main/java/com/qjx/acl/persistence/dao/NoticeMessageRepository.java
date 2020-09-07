package com.qjx.acl.persistence.dao;

import com.qjx.acl.persistence.entity.NoticeMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface NoticeMessageRepository extends JpaRepository<NoticeMessage,Long> {

    @PostFilter("hasPermission(filterObject,'READ')")
    List<NoticeMessage> findAll();

    @PostAuthorize("hasPermission(returnObject,'READ')")
    NoticeMessage findAllById(Integer id);

    @PreAuthorize(("hasPermission(#noticeMessage,'WRITE')"))
    NoticeMessage save(@Param("noticeMessage") NoticeMessage noticeMessage);


}
