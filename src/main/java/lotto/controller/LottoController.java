package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.util.Util;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ResultView;

public class LottoController {

    private int lottoPrice;
    private List<List<LottoNumber>> lottoLists;
    private Lottos lottos;
    private String winningNumber;
    private List<Integer> winningNumberList;
    private int bonusBall;

    public void start() {
        lottoPriceProcess();
        lottoListsProcess();
        lottoCountProcess();
        winningNumberProcess();
        bonusBallProcess();
//        statisticsProcess();
    }

    private void lottoPriceProcess() {
        OutputView.printRequestLottoPrice();
        lottoPrice = InputView.readPrice();
    }

    private void lottoListsProcess() {
        lottos = new Lottos(lottoPrice);
        lottoLists = lottos.getLottoLists();
//        ResultView.printLottoNumbers(lottoLists);
    }

    private void lottoCountProcess() {
        OutputView.printLottoCount(lottos.getLottoCount());
    }

    private void winningNumberProcess() {
        OutputView.printWinningNumberBefore();
        winningNumber = InputView.readWinningNumber();
        winningNumberList = Util.stringToIntegerList(winningNumber);
    }

    private void bonusBallProcess() {
        OutputView.printBonusBallNumber();
        bonusBall = InputView.readBonusNumber();
    }

//    private void statisticsProcess() {
//        LottoStatistics lottoStatistics = new LottoStatistics(winningNumberList, bonusBall,
//            lottoLists, lottoPrice);
//
//        ResultView.printLottoStatistics(lottoStatistics.getResultStatistics(),
//            lottoStatistics.getLottoEarningRate());
//    }
}
