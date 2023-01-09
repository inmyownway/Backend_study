package hello.core.member;

public class MemberServiceImpl implements MemberService{


    private final MemberRepository memberRepository ;// 인터페이스 의존
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {

        memberRepository.save(member);
    }

    @Override
    public Member findmember(long memberId) {

        return memberRepository.findById(memberId);
    }

    // testDyd 용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
