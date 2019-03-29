package com.cva;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cva.exceptions.VGSException;


@Component
public class BootStrapInitializer {



	/**
	 * @param ready
	 * @throws VGSException
	 */
	@EventListener
	public void onApplicationReady(ApplicationReadyEvent ready) throws VGSException {
		
	}
}
