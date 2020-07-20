package com.prairiesky.cobie.qc.gui;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class TextAreaAppender extends AppenderBase<ILoggingEvent> {

    private static volatile TextArea textArea = null;

    /**
     * Set the target TextArea for the logging information to appear.
     *
     * @param textArea
     */
    public static void setTextArea(final TextArea textArea) {
        TextAreaAppender.textArea = textArea;
    }

    /**
     * Format and then append the loggingEvent to the stored TextArea.
     *
     * @param loggingEvent
     */

    @Override
    protected void append(ILoggingEvent loggingEvent) {
        final String message = loggingEvent.getFormattedMessage();

        // Append formatted message to text area using the Thread.
        try {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (textArea != null) {
                            if (textArea.getText().length() == 0) {
                                textArea.setText(message);
                            } else {
                                textArea.selectEnd();
                                textArea.insertText(textArea.getText().length(), message);
                            }
                        }
                    } catch (final Throwable t) {
                        System.out.println("Unable to append log to text area: " + t.getMessage());
                    }
                }
            });
        } catch (final IllegalStateException e) {
            // ignore case when the platform hasn't yet been iniitialized
        }
    }

}
