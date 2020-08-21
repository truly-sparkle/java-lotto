package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    public void setup() {

        LottoResultNumber lottoResultNumber = new LottoResultNumber(
                new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6), 7));

        List<LottoNumber> lottoNumberList = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            lottoNumberList.add(new LottoNumber(new Ticket(
                    Arrays.asList(i, i + 1, i + 2, i + 3, i + 4, i + 5), i + 6
            )));
        }

        lottoResult = new LottoResult(10000, lottoNumberList, lottoResultNumber);
    }

    @Test
    public void earningsRateTest() {
        assertEquals(200155, lottoResult.calculateEarningsRate());
    }
}
