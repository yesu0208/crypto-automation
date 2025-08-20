package arile.toy.crypto_automation.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "report_histories")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReportHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String market;

    @Column
    private String price;

    @Column
    private LocalDateTime reportedAt;

    public ReportHistory(String market, String price) {
        this.market = market;
        this.price = price;
        this.reportedAt = LocalDateTime.now();
    }
}
