package com.bridgelabz.keyworddriven.utility;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.monte.media.Format;
import org.monte.media.FormatKey;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.screenrecorder.ScreenRecorder;

public class ScreenRecording extends ScreenRecorder{
	public static ScreenRecorder screenRecorder;
	public String name;

	public ScreenRecording(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat,
			Format mouseFormat, Format audioFormat, File movieFolder) throws IOException, AWTException {
		super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
	this.name=name;
	
	}
	protected File makeMovieFormat(Format fileFormat ) throws IOException {
		if(!movieFolder.exists())
		{
			movieFolder.mkdir();
		}
		if(!movieFolder.isDirectory())
		{
			throw new IOException("\""+movieFolder+"is not a directory");
		}
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
		return new File(movieFolder,name+"-"+dateformat.format(new Date())+"."+Registry.getInstance().getExtension(fileFormat));
        		
		
	}
	public static void startRecording(String methodName)
	{
		File file=new File("./recordings");
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int width=screenSize.width;
		int  height=screenSize.height;
		Rectangle captureSize=new Rectangle(0, 0, width, height);
		GraphicsConfiguration gc=GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		//screenRecorder=new ScreenRecording(gc, captureSize, new Format(MediaType,MediaType.FILE, Mim) , new Fo, mouseFormat, audioFormat, movieFolder)
		
				
	}
//	public static void startRecording1(String methodName) throws Exception {
//		File file = new File("./recordings/");
//
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		int width = screenSize.width;
//		int height = screenSize.height;
//
//		Rectangle captureSize = new Rectangle(0, 0, width, height);
//
//		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
//				getDefaultScreenDevice()
//				.getDefaultConfiguration();
//
//		screenRecorder = new ScreenRecording(gc, captureSize,
//				new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
//				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
//						CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
//						Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
//				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
//				null, file, methodName);
//		
//		screenRecorder.start();
//
//	}

	

	

	

}
