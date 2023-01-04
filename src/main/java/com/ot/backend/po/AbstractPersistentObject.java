package com.ot.backend.po;

import com.ot.backend.listener.PersistentListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(PersistentListener.class)
public class AbstractPersistentObject {

    @Column(name = "created_at", columnDefinition = "DATETIME(3)")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", columnDefinition = "DATETIME(3)")
    private LocalDateTime updatedAt = LocalDateTime.now();

}
