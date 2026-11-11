
package com.quantforge.marketdata.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
@Table(
        name = "market_bars",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"instrument_id", "trading_date"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MarketBar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrument_id", nullable = false)
    private Instrument instrument;

    @NotNull
    @Column(name = "trading_date", nullable = false)
    private LocalDate tradingDate;

    @NotNull
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal open;

    @NotNull
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal high;

    @NotNull
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal low;

    @NotNull
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal close;

    @Column(name = "adjusted_close", precision = 19, scale = 4)
    private BigDecimal adjustedClose;

    @NotNull
    @Column(nullable = false)
    private Long volume;
}
