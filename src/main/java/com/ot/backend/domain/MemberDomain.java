package com.ot.backend.domain;

import com.ot.backend.component.Transformer;
import com.ot.backend.controller.params.MemberParam;
import com.ot.backend.po.Member;
import com.ot.backend.repository.CustomRepository;
import com.ot.backend.repository.member.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberDomain extends BaseDomain<Member, Long> {

    private final MemberRepository memberRepository;

    @Transactional
    public Member create(MemberParam param) throws Exception {
        return super.createByPO(Member.class, resourceParam2PO(param, new Member()));
    }

    public MemberDomain(CustomRepository<Member, Long> repository, Transformer transformer,
                        MemberRepository memberRepository) {
        super(repository, transformer);
        this.memberRepository = memberRepository;
    }

    private Member resourceParam2PO(MemberParam param, Member member)
            throws Exception {
        return transformer.param2PO(getClassT(), param, member);
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }
}
