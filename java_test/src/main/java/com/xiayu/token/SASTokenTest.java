package com.xiayu.token;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author xuhongyu
 * @create 2021-11-30 4:11 下午
 */
public class SASTokenTest {
    public static void main(String[] args) {

        String sr = "https://"+"psa-eventhub-prd-02"+".servicebus.windows.net/"+"duckbill-events";
        String authorization = GetSASToken(sr,"DuckbillSendPolicy","+mswIrgatewr76ZsqEzxD/uklukXiWklS6gZMNObYH4=");
        System.out.println(authorization);
    }

    private static String GetSASToken(String resourceUri, String keyName, String key)
    {
        long epoch = System.currentTimeMillis()/1000L;
        int week = 60*60*24*7;
        String expiry = Long.toString(epoch + week);
        String sasToken = null;
        try {
            String stringToSign = URLEncoder.encode(resourceUri, "UTF-8") + "\n" + expiry;
            String signature = getHMAC256(key, stringToSign);
            sasToken = "SharedAccessSignature sr=" + URLEncoder.encode(resourceUri, "UTF-8") +"&sig=" +
                    URLEncoder.encode(signature, "UTF-8") + "&se=" + expiry + "&skn=" + keyName;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sasToken;
    }

    public static String getHMAC256(String key, String input) {
        Mac sha256_HMAC = null;
        String hash = null;
        try {
            sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            Base64.Encoder encoder = Base64.getEncoder();
            hash = new String(encoder.encode(sha256_HMAC.doFinal(input.getBytes("UTF-8"))));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return hash;
    }

    /**
     * 3应用Application
     * 之后会个别提供生产环境连接。Connection string for Production will be provided separately after.
     * 3.1通过REST API Via REST API
     * PSA Event Hub Connection String:
     * 对于REST连接，以下内容将显示令牌的构造方式，该令牌用于通过payload向PSA 事件中心进行身份验证：
     * For REST connection, the following will show how the token is being constructed, which is used for authentication to PSA Event Hub over the payload:
     * {名称} {servicebusNamespace} : psa-eventhub-xxx
     * {主题}  {topic} : xxx-events
     * {规则名称} {SAS Name} : xxxSendPolicy
     * {SAS 密钥} {SAS Token/Value} : xxx
     *
     *
     * 这些我们会在邮件提供。We will provide these via email.
     *
     *
     *
     *
     * 3.1.1生成共享访问签名令牌 Generate A Shared-Access-Signature token
     * 令牌是通过采用以下格式编写一个字符串而生成的：
     * SharedAccessSignature sr=https%3A%2F%2F{servicebusNamespace}%2F{topic}&sig={Signature Code}&se={Expiry}&skn={SAS Name}
     * •sr - 所访问资源的 URI
     * 示例Example: https%3A%2F%2Fpsa-eventhub-uat.servicebus.windows.net%2Fxxx-events
     * •sig - 签名。是基于资源 URI 计算的 SHA-256 哈希（上一部分中所述的范围），以及令牌即时过期时间的字符串表示形式，以 CRLF 分隔。Is the SHA-256 hash computed over the {uri} and the string representation of the token {expiry} instant, separated by CRLF.
     * •se - 令牌即时过期时间。 一个整数，反映自 1970 年 1 月 1 日令牌过期的时期 00:00:00 UTC（UNIX 时期）以来的秒数。Integer reflecting seconds since the epoch 00:00:00 UTC on 1 January 1970 (UNIX epoch) when the token expires.
     * •skn - 授权规则的名称。
     * 示例Example: xxxSendPolicy
     *
     * API操作的进一步说明可以从以下URL找到。（抱歉这没有中文网址，不过可拷贝程式即可）Further explanation on the API operation can be found from this URL: https://docs.microsoft.com/en-us/rest/api/eventhub/send-event
     * 以下网址的显示如何用不同的程序语言生成SAS 令牌。You may refer to the URL below to how to programmatically generate SAS token:
     * https://docs.microsoft.com/en-us/rest/api/eventhub/generate-sas-token
     *
     * 3.1.2使用共享访问签名（在 HTTP 级别）Using the Shared Access Signature (at HTTP level)
     *
     * 了解如何为服务总线中的任何实体创建共享访问签名后，便可以执行 HTTP POST：
     * Now that you know how to create Shared Access Signatures in Service Bus, you are ready to perform an HTTP POST:
     *
     * POST https://<servicebusNamespace>.servicebus.windows.net/<topic>/messages
     * Content-Type: application/json
     * Authorization: SharedAccessSignature sr=https%3A%2F%2F<servicebusNamespace>.servicebus.windows.net%2F<topic>&sig=<Signature Code>&se=<Expiry>&skn=<SAS Name>
     * ContentType: application/atom+xml;type=entry;charset=utf-8
     * Body: {event}
     */
}
