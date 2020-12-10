import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HoroscopeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if(req.getParameter("name").isBlank()){
            out.write("Please identify yourself (by indicating your name), so that \n" +
                    "your horoscope can be given!");
            return;
        }
        //js function
        out.write("<html><body>\n" +
                "Hallow \n" +req.getParameter("name")+"<br>"+
                "<script>\n" +
                "        function displayHoroscope(gender, sign){\n" +
                "            if(gender==\"Male\"){\n" +
                "            if(sign<=6){\n" +
                "                document.write(\"You will have a long life.\");\n" +
                "            }else document.write(\"You will have a rich life.\");\n" +
                "        }else if(gender==\"Famale\"){\n" +
                "            if(sign<=6){\n" +
                "                document.write(\"You will find a tall handsome stranger.\");\n" +
                "            }else document.write(\"You will have six children.\");\n" +
                "        }else document.write(\"ERROR\");\n" +
                "        }\n" +
                "        onload=displayHoroscope("+"\'"+req.getParameter("sex")+"\'"+","+req.getParameter("Zodiac")+");\n" +
                "    </script>\n" +
                "    \n" +
                "\n" +
                "</body></html>");

        //resp_out
//        out.write("Hallow "+req.getParameter("name")+"<br>");
//        if(req.getParameter("sex").equals("Male")){
//            if(Integer.parseInt(req.getParameter("Zodiac"))<=6){
//                out.write("You will have a long life.");
//            }else out.write("You will have a rich life.");
//        }else if(req.getParameter("sex").equals("Famale")){
//            if(Integer.parseInt(req.getParameter("Zodiac"))<=6){
//                out.write("You will find a tall handsome stranger.");
//            }else out.write("You will have six children.");
//        }else out.write("ERROR");
    }
}
