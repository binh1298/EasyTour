/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.utils;

import binhpd.dtos.AccountDTO;
import binhpd.dtos.AccountDTOErrorObject;
import binhpd.dtos.TourDetailsDTO;
import binhpd.dtos.TourDetailsDTOErrorObject;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.servlet.ServletContext;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author Binh_Pham
 */
public class BinhPDUltilities implements Serializable
{

    public static final String SQL_DATE_FORMAT = "yyyy-MM-dd hh:mm";
    public static final String TIMESTAMP_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss.S";
    public static final String NO_GAP_DATE_FORMAT = "yyyyMMddhhmmssSSS";
    public static final String VN_DATE_FORMAT = "dd/MM/yyyy hh:mm";
    public static final String DATE_ONLY_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_ONLY_DATE_FORMAT_US = "MM/dd/yyyy";

    public static final String REGEX_EMAIL = "[\\w-]+@([\\w-]+\\.)+[\\w-]+";
    public static final String REGEX_FULLNAME = "[A-Za-z\\s]{6,50}";
    public static final String REGEX_PHONE = "([\\d]){9,12}";

    public static final long ONE_DAY_MS = 86400000;
    public static final String IMAGE_RELATIVE_PATH = "resources\\images\\journeys\\";

    // Validators
    public static boolean isInRange(int minLength, int maxLength, String inputString) throws Exception
    {
        return inputString.length() >= minLength && inputString.length() <= maxLength;
    }

    public static Timestamp addOneDay(Timestamp inputDate)
    {
        return new Timestamp(inputDate.getTime() + ONE_DAY_MS);
    }
    public static Timestamp minusOneDay(Timestamp inputDate)
    {
        return new Timestamp(inputDate.getTime() - ONE_DAY_MS);
    }
    // DTO Validators
    public static boolean isValid(AccountDTO dto, AccountDTOErrorObject dtoErrorObject, String cfPassword) throws Exception
    {
        boolean valid = true;
        if (!isInRange(6, 50, dto.getUsername()))
        {
            valid = false;
            dtoErrorObject.setUsernameError("Username must be between 6 and 50 characters");
        }
        if (dto.getPassword() != null)
        {
            if (!isInRange(6, 50, dto.getPassword()))
            {
                valid = false;
                dtoErrorObject.setPasswordError("Password must be between 6 and 50 characters");
            } else
            {
                if (!dto.getPassword().equals(cfPassword))
                {
                    valid = false;
                    dtoErrorObject.setCfPasswordError("Passwords must match each other!");
                }
            }
        }
        if (!isInRange(6, 200, dto.getAddress()))
        {
            valid = false;
            dtoErrorObject.setAddressError("Address must be between 6 and 200 characters");
        }

        if (!dto.getFullname().matches(REGEX_FULLNAME))
        {
            valid = false;
            dtoErrorObject.setFullnameError("Fullname has to be between 6 and 50 characters words only!");
        }
        if (!dto.getEmail().matches(REGEX_EMAIL))
        {
            valid = false;
            dtoErrorObject.setEmailError("Invalid email");
        }
        if (!dto.getPhoneNumber().matches(REGEX_PHONE))
        {
            valid = false;
            dtoErrorObject.setPhoneError("Invalid Phone number");
        }
        return valid;
    }

    public static boolean isValid(TourDetailsDTO dto, TourDetailsDTOErrorObject errorObj, String txtNumberOfJourneys, String txtDuration, String txtTotalAvailableSeats, String txtPriceAdults, String txtPriceChildren, String txtDepatureDateTime,
            String txtDepatureArrivalDateTime, String txtReturnDateTime, String txtReturnArrivalDateTime, String txtGatherDateTime) throws Exception
    {
        boolean valid = true;

        // Required fields
        if (!isInRange(1, 30, dto.getTourDetailsID()))
        {
            valid = false;
            errorObj.setTourDetailsIDError("ID has to be between 1 and 30 characters");
        }
        if (!isInRange(1, 100, dto.getTourTitle()))
        {
            valid = false;
            errorObj.setTourTitleError("Title has to be between 1 and 100 characters");
        }
        if (!isInRange(1, 30, dto.getStatus()))
        {
            valid = false;
            errorObj.setStatusError("Status has to be between 1 and 30 characters");
        }
        if (!isInRange(1, 200, dto.getCreatorUsername()))
        {
            valid = false;
            errorObj.setCreatorUsernameError("Creator has to be between 1 and 200 characters");
        }

        // Updatable fields
        if (dto.getDepatureFlightName().isEmpty())
        {
            dto.setDepatureFlightName("Updating");
        } else
        {
            if (!isInRange(1, 30, dto.getDepatureFlightName()))
            {
                valid = false;
                errorObj.setDepatureFlightNameError("This field has to be between 1 and 30 characters");
            }
        }

        if (dto.getReturnFlightName().isEmpty())
        {
            dto.setReturnFlightName("Updating");
        } else
        {
            if (!isInRange(1, 30, dto.getReturnFlightName()))
            {
                valid = false;
                errorObj.setReturnFlightNameError("This field has to be between 1 and 30 characters");
            }
        }
        if (dto.getHotelDescription().isEmpty())
        {
            dto.setHotelDescription("Updating");
        } else
        {
            if (!isInRange(1, 200, dto.getHotelDescription()))
            {
                valid = false;
                errorObj.setHotelDescriptionError("This field has to be between 1 and 200 characters");
            }
        }
        if (dto.getGuideName().isEmpty())
        {
            dto.setGuideName("Updating");
        } else
        {
            if (!isInRange(1, 50, dto.getGuideName()))
            {
                valid = false;
                errorObj.setGuideNameError("This field has to be between 1 and 50 characters");
            }
        }
        if (dto.getGuideAddress().isEmpty())
        {
            dto.setGuideAddress("Updating");
        } else
        {
            if (!isInRange(1, 200, dto.getGuideAddress()))
            {
                valid = false;
                errorObj.setGuideAddressError("This field has to be between 1 and 200 characters");
            }
        }
        if (dto.getGuidePhoneNumber().isEmpty())
        {
            dto.setGuidePhoneNumber("Updating");
        } else
        {
            if (!isInRange(1, 30, dto.getGuidePhoneNumber()))
            {
                valid = false;
                errorObj.setGuidePhoneNumberError("This field has to be between 1 and 30 characters");
            }
        }
        if (dto.getGatherPlace().isEmpty())
        {
            dto.setGatherPlace("Updating");
        } else
        {
            if (!isInRange(1, 200, dto.getGatherPlace()))
            {
                valid = false;
                errorObj.setGatherPlaceError("This field has to be between 1 and 200 characters");
            }
        }
        if (dto.getDepatureCity().isEmpty())
        {
            dto.setDepatureCity("Updating");
        } else
        {
            if (!isInRange(1, 100, dto.getDepatureCity()))
            {
                valid = false;
                errorObj.setDepatureCityError("This field has to be between 1 and 100 characters");
            }
        }
        if (dto.getDestination().isEmpty())
        {
            dto.setDestination("Updating");
        } else
        {
            if (!isInRange(1, 100, dto.getDestination()))
            {
                valid = false;
                errorObj.setDestinationError("This field has to be between 1 and 100 characters");
            }
        }
        // Integers and floats
        if (!isInRange(1, 30, txtNumberOfJourneys))
        {
            valid = false;
            errorObj.setNumberOfJourneysError("Number of journeys is required!");
        }

        if (dto.getNumberOfJourneys() < 1) // Required field
        {
            valid = false;
            errorObj.setNumberOfJourneysError("At least 1 journeys is required!");
        }

        if (!txtDuration.isEmpty())
        {
            if (dto.getDuration() < 0)
            {
                valid = false;
                errorObj.setDurationError("Please enter a valid positive integer");
            }
        }
        if (!txtTotalAvailableSeats.isEmpty())
        {
            if (dto.getTotalAvailableSeats() < 0)
            {
                valid = false;
                errorObj.setTotalAvailableSeatsError("Please enter a valid positive integer");
            }
        }

        if (!txtPriceAdults.isEmpty())
        {
            if (dto.getPriceAdults() < 0)
            {
                valid = false;
                errorObj.setPriceAdultsError("Please enter a valid positive float");
            }
        }
        if (!txtPriceChildren.isEmpty())
        {
            if (dto.getPriceChildren() < 0)
            {
                valid = false;
                errorObj.setPriceChildrenError("Please enter a valid positive integer");
            }
        }

        // Datetime
        if (!txtDepatureDateTime.isEmpty())
        {
            if (dto.getDepatureDateTime() == null)
            {
                valid = false;
                errorObj.setDepatureDateTimeError("The date time format is yyyy-MM-dd hh:mm");
            }
        }

        if (!txtDepatureArrivalDateTime.isEmpty())
        {
            if (dto.getDepatureArrivalDateTime() == null)
            {
                valid = false;
                errorObj.setDepatureArrivalDateTimeError("The date time format is yyyy-MM-dd hh:mm");
            }
        }
        if (!txtReturnDateTime.isEmpty())
        {
            if (dto.getReturnDateTime() == null)
            {
                valid = false;
                errorObj.setReturnDateTimeError("The date time format is yyyy-MM-dd hh:mm");
            }
        }
        if (!txtReturnArrivalDateTime.isEmpty())
        {
            if (dto.getReturnArrivalDateTime() == null)
            {
                valid = false;
                errorObj.setReturnArrivalDateTimeError("The date time format is yyyy-MM-dd hh:mm");
            }
        }
        if (!txtGatherDateTime.isEmpty())
        {
            if (dto.getGatherDateTime() == null)
            {
                valid = false;
                errorObj.setGatherDateTimeError("The date time format is yyyy-MM-dd hh:mm");
            }
        }

        return valid;
    }

    // Converters: Return null or 0 if not validated
    public static Timestamp convertTimestampStringToSqlDatetime(String inputString) throws Exception
    {
        Timestamp timestamp = null;
        Date parsedDate = null;
        try
        {
            try
            {
                SimpleDateFormat dateFormat = new SimpleDateFormat(SQL_DATE_FORMAT);
                parsedDate = dateFormat.parse(inputString);
                timestamp = new java.sql.Timestamp(parsedDate.getTime());
            } catch (Exception e)
            {
                SimpleDateFormat dateFormat = new SimpleDateFormat(VN_DATE_FORMAT);
                parsedDate = dateFormat.parse(inputString);
                timestamp = new java.sql.Timestamp(parsedDate.getTime());
            }
        } catch (Exception e)
        {
            timestamp = null;
        }
        return timestamp;
    }

    public static Timestamp convertDateStringToSqlDateTime(String inputString) throws Exception
    {
        Timestamp timestamp = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_ONLY_DATE_FORMAT_US);
        Date parsedDate = null;
        try
        {
            try
            {
                parsedDate = dateFormat.parse(inputString);
            } catch (Exception e)
            {
                dateFormat = new SimpleDateFormat(TIMESTAMP_DATE_FORMAT);
                parsedDate = dateFormat.parse(inputString);
            }
            timestamp = new java.sql.Timestamp(parsedDate.getTime());
        } catch (Exception e)
        {
            timestamp = null;
        }
        return timestamp;
    }

    public static float convertToFloat(String inputString) throws Exception
    {
        float result = 0;
        try
        {
            result = Float.parseFloat(inputString);
        } catch (Exception e)
        {
            result = -1;
        }
        return result;
    }

    public static int convertToInt(String inputString) throws Exception
    {
        int result = 0;
        try
        {
            result = Integer.parseInt(inputString);
        } catch (Exception e)
        {
            result = -1;
        }
        return result;
    }

//    public static Date convertTime(Timestamp inputDateTime) throws Exception
//    {
//        Date result = null;
//        SimpleDateFormat dateFormat = new SimpleDateFormat("");
//        try
//        {
//            dateFormat.parse(inputDateTime.toString());
//        } catch (Exception e)
//        {
//            result = null;
//        }
//        return result;
//    }
    // Files
    public static String getProjectFolderRealPath(ServletContext context) throws Exception
    {
        String result = null;
        String serverRealPath = context.getRealPath("/");
        try
        {
            result = serverRealPath.substring(0, serverRealPath.lastIndexOf("\\build\\web\\"));
            result = result + "\\web\\";
        } catch (Exception e)
        {
            result = null;
        }
        return result;
    }

    public static Timestamp getCurrentDateTime() throws Exception
    {
        Date currDate = new Date();
        Timestamp result = new Timestamp(currDate.getTime());
        return result;
    }

    public static String generateUniqueTimeString() throws Exception
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(NO_GAP_DATE_FORMAT);
        String result = dateFormat.format(new Date()) + "";
        return result;
    }

    public static String generateFileDirectory(String imageFileName) throws Exception
    {
        return IMAGE_RELATIVE_PATH + generateUniqueTimeString() + imageFileName;
    }

    public static boolean saveFile(String fileRealPath, FileItem originalFile, ServletContext context) throws Exception
    {
        boolean check = true;
        fileRealPath = getProjectFolderRealPath(context) + fileRealPath;
//        System.out.println(fileRealPath);
        File savedFile = new File(fileRealPath);
        if (savedFile.createNewFile())
        {
            originalFile.write(savedFile);
        } else
        {
            check = false;
        }
        return check;
    }
}
