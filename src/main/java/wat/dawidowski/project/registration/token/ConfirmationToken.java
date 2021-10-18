package wat.dawidowski.project.registration.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import wat.dawidowski.project.appuser.AppUser;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@NoArgsConstructor
public class ConfirmationToken {
    public ConfirmationToken(String token, LocalDateTime createdTime, LocalDateTime endTime, AppUser appUser) {
        this.token = token;
        this.createdTime = createdTime;
        this.endTime = endTime;
        this.appUser = appUser;
    }

    @SequenceGenerator(
            name="confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1

    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence")
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    private LocalDateTime confirmedTime;

    @ManyToOne
    @JoinColumn(nullable = false,
            name="app_user_id")
    private AppUser appUser;


}
