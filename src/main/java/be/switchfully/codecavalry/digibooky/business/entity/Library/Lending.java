package be.switchfully.codecavalry.digibooky.business.entity.Library;

import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;

import java.time.LocalDate;
import java.util.UUID;

public class Lending {

    public static final Long TIME_TO_LEND=3L;
    private final String Id;
    private final SocialSecurityNumber memberId;
    private final Long isbn;
    private LocalDate dateOfLending;
    private LocalDate dateOfReturning;

    public Lending(SocialSecurityNumber memberId, Long isbn) {
        this.Id = UUID.randomUUID().toString();
        this.memberId = memberId;
        this.isbn = isbn;
        this.dateOfLending = LocalDate.now();
        this.dateOfReturning = LocalDate.now().plusWeeks(TIME_TO_LEND);
    }

    public String getId() {
        return Id;
    }

    public SocialSecurityNumber getMemberId() {
        return memberId;
    }

    public Long getIsbn() {
        return isbn;
    }

    public LocalDate getDateOfLending() {
        return dateOfLending;
    }

    public LocalDate getDateOfReturning() {
        return dateOfReturning;
    }
}
