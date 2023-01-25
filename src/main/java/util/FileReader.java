package util;

import java.io.*;

public class FileReader {
    private static String readFile( InputStream fStream ) throws IOException
    {
        StringBuffer   sbContent = new StringBuffer();
        BufferedReader reader    = null;

        try
        {
            reader = new BufferedReader( new InputStreamReader( fStream ) );
            String content = reader.readLine();

            while( content != null )
            {
                sbContent.append( content ).append( "\n" );
                content = reader.readLine();
            }
        }
        finally
        {
            if( reader != null )
            {
                reader.close();
            }
        }

        return sbContent.toString();
    }
    public static String readFileFromSystem( String fileName, String dataFolderpath ) throws IOException
    {
        String content = null;
        try
        {
            File file    = new File( dataFolderpath + File.separator + fileName );
            FileInputStream fStream = new FileInputStream( file );
            content = readFile( fStream );
        }
        catch( IOException ex )
        {
            System.out.print( "Exception while reading the file " + fileName );
            throw ex;
        }

        return content;
    }
}
