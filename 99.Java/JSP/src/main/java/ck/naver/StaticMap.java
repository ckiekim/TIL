package ck.naver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StaticMap
 */
@WebServlet("/naver/static")
public class StaticMap extends HttpServlet {
    private String accessId;
    private String secretKey;

    public StaticMap() {
        super();
        Properties props = new Properties();
        try {
            InputStream is = new FileInputStream("c:/Temp/naver.properties");
            props.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        accessId = props.getProperty("accessId");
        secretKey = props.getProperty("secretKey");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
        response.sendRedirect("/naver/sample/staticForm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String width = request.getParameter("width");
		String height = request.getParameter("height");
		String lat = request.getParameter("lat");
		String lng = request.getParameter("lng");
		String level = request.getParameter("level");
		String maptype = request.getParameter("maptype");
		String format = request.getParameter("format");
		String scale = request.getParameter("scale");
		String lang = request.getParameter("lang");
		
		String url = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster"
		            + "?w=" + width 
		            + "&h=" + height
		            + "&center=" + lng + "," + lat
		            + "&level=" + level
		            + "&maptype=" + maptype
		            + "&format=" + format
		            + "&scale=" + scale
		            + "&lang=" + lang
		            + "&X-NCP-APIGW-API-KEY-ID=" + accessId
		            + "&X-NCP-APIGW-API-KEY=" + secretKey;
		
		List<Place> placeList = new ArrayList<>();
		placeList.add(new Place(37.5383, 127.0824, "t", "tiny", "광진구청"));
		placeList.add(new Place(37.5483, 127.0824, "t", "tiny", "위도 +0.01"));
		placeList.add(new Place(37.5383, 127.0924, "t", "tiny", "경도 +0.01"));
		for (Place p: placeList) {
		    String marker = "type:" + p.getType() + "|size:" + p.getSize() 
		                    + "|pos:" + p.getLng() + " " + p.getLat() + "|label:" + p.getLabel();
		    marker = URLEncoder.encode(marker, "utf-8");
		    url += "&markers=" + marker;
		}
		url += "&markers=type:d|size:mid|pos:127.0724%2037.5283";
		url += "&markers=type:d|size:small|pos:127.0724%2037.5483|color:red";
		
		request.setAttribute("url", url);
		RequestDispatcher rd = request.getRequestDispatcher("/naver/sample/staticResult.jsp");
		rd.forward(request, response);
	}

}
