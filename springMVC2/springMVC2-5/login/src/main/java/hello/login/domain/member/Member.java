package hello.login.domain.member;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Member {

    private Long id;

    @NotEmpty
    private String loginId; // 로그인 ID 닉네임
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
}
