package arile.toy.crypto_automation.service;

import arile.toy.crypto_automation.http.SlackHttpClient;
import arile.toy.crypto_automation.http.UpbitHttpClient;
import arile.toy.crypto_automation.http.UpbitTickerDto;
import arile.toy.crypto_automation.repository.ReportHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpbitSlackService {
    private final SlackHttpClient slackHttpClient;
    private final UpbitHttpClient upbitHttpClient;
    private final ReportHistoryRepository repository;

    public void execute(String market) {
        // upbit 호출
        UpbitTickerDto tickerByMarket =  upbitHttpClient.getTickerByMarket(market);

        // slack message 쏜다 + formatting
        StringBuilder sb = new StringBuilder();
        sb.append("[실시간 데이터] ");
        sb.append(market);
        sb.append(" price = ");
        sb.append(tickerByMarket.getTrade_price());
        slackHttpClient.send(sb.toString());

        repository.save(market, String.valueOf(tickerByMarket.getTrade_price()));
    }
}
