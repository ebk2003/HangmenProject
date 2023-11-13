/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.GameUtil;

/**
 *
 * @author USER
 */
@WebServlet(name = "GameServlet", urlPatterns = {"/GameServlet"})
public class GameServlet extends HttpServlet {
private boolean isFirst;
    private GameUtil gameUtil ;
String sentenceToShow = GameUtil.sentenceToShow.toString();

    public void showPage(HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            String out2 = "<html>\n"
                    + "    <head>\n"
                    + "        <title>the hangman</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <h1>play now</h1>\n"
                    + "        <div>" + gameUtil.sentenceToShow + "</div>\n"
                    + "        <div>" + gameUtil.numOfTryings + "</div>\n"
                    + "       <form action=\"GameServlet\" method=\"get\">\n  "
                    + " <input type='text' name='letter' placeholder=\" הכנס אות \" />\n"
                    + "            <input type=\"submit\" value=\"הגש\"/>"
                    + "        <form/>\n"
                    + "    </body>\n"
                    + "</html>";
            out.print(out2);
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
//     */

   

    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
{
    if(isFirst){
        showPage(response);
        isFirst=false;
    }
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    

    // Initialize gameUtil here
    if (gameUtil == null) {
        gameUtil = new GameUtil();
    }

    String letter = request.getParameter("letter");
    if (letter != null) {
//        out.print(gameUtil.sentenceToShow);
        gameUtil.updateSentenceToShow(letter.charAt(0));
        gameUtil.increaseNumOfTryings();
        if (gameUtil.checkWinning()) {
            response.sendRedirect("WinServlet");
            return;
        }
    }

    // Display the updated page with the current state of the game
    showPage(response);
}

    @Override
    public void init() throws ServletException {
        gameUtil = new GameUtil();
        isFirst=true;
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
