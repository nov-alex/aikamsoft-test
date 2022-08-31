package test.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Setter
@Getter
public class StatResponseDto extends BaseResponseDto {

    public StatResponseDto() {
        super.setType("stat");
        this.customers = new ArrayList<>();
        this.totalDays = 0L;
        this.totalExpenses = 0D;
        this.avgExpenses = 0D;
    }

    private long totalDays;
    private List<StatsCustomerProductDto> customers;
    private double totalExpenses;
    private double avgExpenses;

    public static Long countBusinessDaysBetween(final LocalDate startDate,
                                                final LocalDate endDate) {
        Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
                || date.getDayOfWeek() == DayOfWeek.SUNDAY;

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        return Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(daysBetween)
                .filter(isWeekend.negate())
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StatResponseDto that = (StatResponseDto) o;
        return totalDays == that.totalDays && Double.compare(that.totalExpenses, totalExpenses) == 0 && Double.compare(that.avgExpenses, avgExpenses) == 0 && Objects.equals(customers, that.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalDays, customers, totalExpenses, avgExpenses);
    }
}
