/*
implementation("org.jsoup:jsoup:1.14.3")
implementation("com.squareup.okhttp3:okhttp:4.9.3")
 */

import okhttp3.OkHttpClient
import okhttp3.Request
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

data class Song(val rank: String, val img: String, val title: String, val artist: String, val album: String)

fun main() {
    val url = "https://www.genie.co.kr/chart/top200"
    val client = OkHttpClient()

    val request = Request.Builder()
        .url(url)
        .header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
        .build()

    val response = client.newCall(request).execute()
    val html = response.body?.string()
    
    val doc: Document = Jsoup.parse(html)
    val trs: Elements = doc.select("tr.list")
    
    val songs = mutableListOf<Song>()
    
    for (tr in trs.subList(0, 10)) {
        val rank = tr.select(".number").text().split("\n")[0].trim()
        val img = "https:" + tr.select(".cover > img").attr("src")
        val title = tr.select(".title.ellipsis").text().split("\n").last().trim()
        val artist = tr.select(".artist.ellipsis").text().trim()
        val album = tr.select(".albumtitle.ellipsis").text().trim()

        songs.add(Song(rank, img, title, artist, album))
    }

    // 결과 출력
    songs.forEach { song ->
        println("Rank: ${song.rank}, Title: ${song.title}, Artist: ${song.artist}, Album: ${song.album}, Img: ${song.img}")
    }
}
