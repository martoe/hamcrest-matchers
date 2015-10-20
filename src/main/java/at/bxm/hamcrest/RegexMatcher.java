package at.bxm.hamcrest;

import java.util.regex.Pattern;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/** Hamcrest matcher for regular expressions */
public class RegexMatcher extends TypeSafeMatcher<String> {

  private final Pattern pattern;

  RegexMatcher(String regex) {
    pattern = Pattern.compile(regex);
  }

  @Override
  public boolean matchesSafely(String item) {
    return pattern.matcher(item).matches();
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("matches regex=").appendValue(pattern);
  }

  @Factory
  public static RegexMatcher matches(String regex) {
    return new RegexMatcher(regex);
  }
}
