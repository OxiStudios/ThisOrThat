package com.OxiStudios.ThisOrThat;

import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.uikit.UIApplication;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;

public class RobovmLauncher extends IOSApplication.Delegate {
	@Override
	protected IOSApplication createApplication() {
		IOSApplicationConfiguration config = new IOSApplicationConfiguration();
		config.orientationLandscape = false;
		config.orientationPortrait = true;
		return new IOSApplication(new ThisOrThatGame(), config);
	}

	public static void main(String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, RobovmLauncher.class);
		pool.drain();
	}
}
