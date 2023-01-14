package com.ot.backend.po;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
class MemberTest {

    @Test
    public void TEST() {
        Member member = new Member();

        assertNotNull(member);

        Member member1 = new Member(1L, "test", "test");

        Member member2 = Member.builder().name("test").email("test").build();


    }

}