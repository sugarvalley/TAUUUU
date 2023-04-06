import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AnimeTest {
    Anime animes = mock(Anime.class);

    String url = "https://animechan.vercel.app/api/";
    @Test
    public void randomAnimeQuoteTest(){
        when(animes.randomAnimeQuote(url+"/random")).thenReturn("{\n" +
                "    \"anime\": \"Denpa Kyoushi\",\n" +
                "    \"character\": \"Kagami Junichirou\",\n" +
                "    \"quote\": \"Paying the price for something valuable, that's the pride of an otaku.\"\n" +
                "}");
        String randomAnimeQuote = animes.randomAnimeQuote(url+"/random");
        Assert.assertEquals(randomAnimeQuote,"{\n" +
            "    \"anime\": \"Denpa Kyoushi\",\n" +
                    "    \"character\": \"Kagami Junichirou\",\n" +
                    "    \"quote\": \"Paying the price for something valuable, that's the pride of an otaku.\"\n" +
                    "}");
    }

    @Test
    public void allNamesTest(){
        when(animes.allNames(url+"/available/anime")).thenReturn("[\n" +
                "    \"Naruto\",\n" +
                "    \"One punch man\",\n" +
                "    \"Bleach\",\n" +
                "]");
        String allNames = animes.allNames(url+"/available/anime");
        Assert.assertEquals(allNames,"[\n" +
                        "    \"Naruto\",\n" +
                        "    \"One punch man\",\n" +
                        "    \"Bleach\",\n" +
                "]");
    }
    @Test
    public void getNamesTest(){
        when(animes.getNames(url+"/random/character?name=saitama")).thenReturn("{\n" +
                "    \"anime\": \"One Punch Man\",\n" +
                "    \"character\": \"Saitama\",\n" +
                "    \"quote\": \"Human beings are strong because we have the ability to change ourselves.\"\n" +
                "}");
        String getNames = animes.getNames(url+"/random/character?name=saitama");
        Assert.assertEquals(getNames,"{\n" +
                "    \"anime\": \"One Punch Man\",\n" +
                "    \"character\": \"Saitama\",\n" +
                "    \"quote\": \"Human beings are strong because we have the ability to change ourselves.\"\n" +
                "}");
    }

    @Test
    public void random10QuotesTest(){
        when(animes.random10Quotes(url+"/quotes")).thenReturn("[{\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "}]");
        String random10Quotes = animes.random10Quotes(url+"/quotes");
        Assert.assertEquals(random10Quotes,"[{\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "    \"anime\": [\"Jinrui wa Suitai Shimashita\"],\n" +
                "    \"character\": \"Watashi\",\n" +
                "    \"quote\": \"They have no faces, no mouths... Their slimy bodies are completely hairless! They are... the skinned chickens!... Or you could just say they're chickens.\",\n" +
                "}]");
    }
}