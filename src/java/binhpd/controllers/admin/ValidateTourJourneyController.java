/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.controllers.admin;

import binhpd.dtos.TourJourneyDTO;
import binhpd.dtos.TourJourneyDTOErrorObject;
import binhpd.utils.BinhPDUltilities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author User
 */
public class ValidateTourJourneyController extends HttpServlet
{

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS_INSERT = "InsertTourJourneyController";
    private static final String SUCCESS_UPDATE = "UpdateTourJourneyController";
    private static final String INVALID_INSERT = "adminAddTourJourney.jsp";
    private static final String INVALID_UPDATE = "adminEditTourJourney.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try
        {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart)
            {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List<FileItem> items = upload.parseRequest(request);
                Hashtable<String, String> params = new Hashtable<>();
                ArrayList<FileItem> images = new ArrayList<>();
                for (FileItem item : items)
                {
                    if (item.isFormField())
                    {
                        params.put(item.getFieldName(), item.getString("UTF-8"));
                    } else
                    {
                        images.add(item);
                    }
                }
                String submit = params.get("submit");
                String txtTourJourneyID, tourDetailsID, timeStamp, title, description, imageName, imageDirectory;
                int tourJourneyID = 0;
                int numberOfJourneys = BinhPDUltilities.convertToInt(params.get("numberOfJourneys"));
                tourDetailsID = params.get("tourDetailsID");
                boolean valid = true;
                TourJourneyDTO dto = null;
                ArrayList<TourJourneyDTO> journeys = new ArrayList<>();
                TourJourneyDTOErrorObject errorObj = null;
                ArrayList<TourJourneyDTOErrorObject> errorObjects = new ArrayList<>();
                ArrayList<String> tempDir = new ArrayList();
                for (int i = 0; i < numberOfJourneys; i++)
                {
                    errorObj = new TourJourneyDTOErrorObject();
                    timeStamp = params.get("timeStamp" + i);
                    title = params.get("title" + i);
                    description = params.get("description" + i);
                    imageName = images.get(i).getName();
                    imageDirectory = params.get("imageDirectory" + i);
                    txtTourJourneyID = params.get("tourJourneyID" + i);
                    String temp = params.get("temporaryImgDir" + i);
                    tempDir.add(temp);

                    if (timeStamp.isEmpty())
                    {
                        timeStamp = "Updating";
                    } else
                    {
                        if (!BinhPDUltilities.isInRange(1, 30, timeStamp))
                        {
                            valid = false;
                            errorObj.setTimeStampError("has to be between 1 and 30 characters");
                        }
                    }
                    if (title.isEmpty())
                    {
                        title = "Updating";
                    } else
                    {
                        if (!BinhPDUltilities.isInRange(1, 100, title))
                        {
                            valid = false;
                            errorObj.setTitleError("has to be between 1 and 100 characters");
                        }
                    }

                    if (description.isEmpty())
                    {
                        description = "Updating";
                    } else
                    {
                        if (!BinhPDUltilities.isInRange(1, 2000, description))
                        {
                            valid = false;
                            errorObj.setDescriptionError("has to be between 1 and 2000 characters");
                        }
                    }
                    if (submit.equals("Edit Journeys"))
                    {
                        tourJourneyID = BinhPDUltilities.convertToInt(txtTourJourneyID);
                        if (tourJourneyID < 0)
                        {
                            valid = false;
                            request.setAttribute("INVALID", "Invalid journey ID!!!");
                        }
                    }
                    if (imageName.isEmpty())
                    {
                        if (imageDirectory == null)
                        {
                            imageDirectory = "Updating";
                        }
                        if (imageDirectory.isEmpty())
                        {
                            imageDirectory = "Updating";
                        }
                    } else
                    {
                        imageDirectory = BinhPDUltilities.generateFileDirectory(imageName);
                        BinhPDUltilities.saveFile(imageDirectory, images.get(i), getServletContext());
                        if (!BinhPDUltilities.isInRange(1, 500, imageDirectory))
                        {
                            valid = false;
                            errorObj.setImageDirectoryError("We can not save this image to disk!");
                        }
                    }
                    dto = new TourJourneyDTO(tourJourneyID, tourDetailsID, timeStamp, title, description, imageDirectory.replace("\\", "/"));
                    journeys.add(dto);
                    errorObjects.add(errorObj);
                }
                request.setAttribute("journeys", journeys);
                request.setAttribute("errorObjects", errorObjects);
                request.setAttribute("tourDetailsID", tourDetailsID);
                request.setAttribute("tempDir", tempDir); // for fake files
                if (valid)
                {
                    if (submit.equals("Add Journeys"))
                    {
                        url = SUCCESS_INSERT;
                    } else if (submit.equals("Edit Journeys"))
                    {
                        url = SUCCESS_UPDATE;
                    }
                } else
                {
                    if (submit.equals("Add Journeys"))
                    {
                        url = INVALID_INSERT;
                    } else if (submit.equals("Edit Journeys"))
                    {
                        url = INVALID_UPDATE;
                    }
                }
            } else
            {
                request.setAttribute("ERROR", "What are you trying to do?");
            }
        } catch (Exception e)
        {
            log("ERROR in ValidateTourJourneyController: " + e.getMessage());
        } finally
        {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
