package com.prairiesky.cobie.tool.util;

import org.apache.commons.cli.Option;

public interface OptionProvider
{
	/**
	 * An instance of {@code org.apache.commons.cli.Option}
	 * @return
	 */
	Option getOption();
}
