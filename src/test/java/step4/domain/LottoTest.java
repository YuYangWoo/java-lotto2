package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    /**
     * - Lotto
     * - 생성 시 LottoNumber의 배열이 6자리가 아니면 runtime exception
     * - getCountOfMatch() 비교 후 일치하는 숫자의 갯수를 반환
     * - LottoNumber 배열 sort()
     */

    @DisplayName("LottoNumber의 배열이 6자리가 아니면 runtime exception")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2", "1,2,3", "1,2,3,4", "1,2,3,4,5"})
    void notNumberTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(input));
    }

    @DisplayName("생성 시 오름차순으로 정렬된다.")
    @ParameterizedTest
    @CsvSource(value = {"6,5,4,3,2,1:1,2,3,4,5,6", "10,5,34,42,35,45:5,10,34,35,42,45"}, delimiter = ':')
    void sortTest(String input, String expectStr) {
        Lotto actual = Lotto.of(input);
        Lotto expect = Lotto.of(expectStr);

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("getCountOfMatch() 일치하는 갯수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1,2,3,7,8,9:3", "1,2,3,4,5,6:7,8,9,10,11,12:0", "10,5,34,42,35,45:5,11,12,13,14,15:1", "1,2,3,4,5,6:1,2,3,4,5,6:6"}, delimiter = ':')
    void sortTest(String input, String compareStr, long expect) {
        Lotto myLotto = Lotto.of(input);
        Lotto winningLotto = Lotto.of(compareStr);

        assertThat(myLotto.countOfMatch(winningLotto)).isEqualTo(expect);
    }

    @DisplayName("containLottoNumber는 Lotto에 LottoNumber가 포함되어 있는지 확인한다.")
    @Test
    void containTest() {
        Lotto lotto = Lotto.of("1,2,3,4,5,6");

        assertThat(lotto.containLottoNumber(LottoNumber.of(1))).isTrue();
        assertThat(lotto.containLottoNumber(LottoNumber.of(2))).isTrue();
        assertThat(lotto.containLottoNumber(LottoNumber.of(3))).isTrue();
        assertThat(lotto.containLottoNumber(LottoNumber.of(4))).isTrue();
        assertThat(lotto.containLottoNumber(LottoNumber.of(5))).isTrue();
        assertThat(lotto.containLottoNumber(LottoNumber.of(6))).isTrue();
        assertThat(lotto.containLottoNumber(LottoNumber.of(7))).isFalse();
    }

}