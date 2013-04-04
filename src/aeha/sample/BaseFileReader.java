package aeha.sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class BaseFileReader {

	protected String return_code = "\r\n";
	protected String charset     = "Windows-31J";

	public void readFile( File file ) throws FileNotFoundException, IOException{
		FileInputStream iStream = null;
		InputStreamReader iReader = null;
		BufferedReader bReader = null;

		try {
			iStream = new FileInputStream( file );
			iReader = new InputStreamReader( iStream, charset );
			bReader = new BufferedReader( iReader );

			String read_buffer = "";
			while ( (read_buffer = bReader.readLine()) != null ) {
				doPerform( read_buffer );
			}

		} catch( FileNotFoundException e ) {
			throw e;
		} catch( IOException e ) {
			throw e;
		} finally {
			try {
				if ( bReader != null ) { bReader.close(); }
				if ( iStream != null ) { iStream.close(); }
				if ( iReader != null ) { iReader.close(); }
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}

		return;
	}


	abstract public void doPerform(String str);


}
