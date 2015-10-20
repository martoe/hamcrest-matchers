package at.bxm.hamcrest;

import static java.util.Calendar.*;

import java.util.Calendar;
import java.util.Date;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/** Hamcrest matcher for dates */
public class SameDayMatcher extends TypeSafeMatcher<Date> {

  private final Date date;

  SameDayMatcher(Date date) {
    this.date = date;
  }

  @Override
  public boolean matchesSafely(Date matchingDate) {
    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(date);
    Calendar cal2 = Calendar.getInstance();
    cal2.setTime(matchingDate);
    return cal1.get(ERA) == cal2.get(ERA) && cal1.get(YEAR) == cal2.get(YEAR) && cal1.get(DAY_OF_YEAR) == cal2.get(DAY_OF_YEAR);
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("same day as ").appendValue(date);
  }

  @Factory
  public static SameDayMatcher sameDayAs(Date date) {
    return new SameDayMatcher(date);
  }
}
