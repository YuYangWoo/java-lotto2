package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.view.OutputView;

public class Lottos {

    private static final int ERROR_WRONG_LOTTO_PRICE = 0;
    private static final int LOTTO_PRICE = 1000;

    List<Lotto> lottoLists;
    final int lottoCount;

    public Lottos(LottoPrice lottoPrice) {
        validateLottoPrice(lottoPrice.getPrice());

        this.lottoCount = lottoPrice.getPrice() / LOTTO_PRICE;
        this.lottoLists = generatorLottos();
    }

    public List<Lotto> getLottoLists() {
        return Collections.unmodifiableList(lottoLists);
    }

    private List<Lotto> generatorLottos() {
        List<Lotto> lottoLists = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoLists.add(LottoNumberGenerator.generate());
        }

        return lottoLists;
    }

    private void validateLottoPrice(int totalPrice) {
        if (totalPrice % LOTTO_PRICE != ERROR_WRONG_LOTTO_PRICE) {
            throw new IllegalArgumentException(OutputView.ERROR_WRONG_LOTTO_PRICE);
        }
    }
    public int getLottoCount() {
        return lottoCount;
    }
}
