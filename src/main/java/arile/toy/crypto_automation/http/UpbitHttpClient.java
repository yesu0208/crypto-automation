package arile.toy.crypto_automation.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UpbitHttpClient {
    private final HttpClient httpClient;

    public UpbitTickerDto getTickerByMarket(String market){
        try{

            HttpHeaders headers = new HttpHeaders(); // upbit에서 header있는지 확인 -> 있다!
            headers.add("accept", "application/json"); // header setting
            String execute = httpClient.execute(
                    "https://api.upbit.com/v1/ticker?markets=" + market,
                    HttpMethod.GET,
                    headers
            ); // String으로 반환
            // ObjectMapper을 이용해서 String -> List 형태로 -> 그런데 첫번째 것만 가져오면 되므로, findFrist 활용
            ObjectMapper objectMapper = new ObjectMapper();
//        List<UpbitTickerDto> upbitTickerDtos = objectMapper
//                .readValue(execute
//                        , new TypeReference<List<UpbitTickerDto>>() {}
//                );
            return objectMapper.readValue(
                    execute,
                    new TypeReference<List<UpbitTickerDto>>() {}
            ).stream().findFirst().get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
