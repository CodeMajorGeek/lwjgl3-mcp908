package net.minecraft.util;

public interface IProgressUpdate
{
    /**
     * Shows the 'Saving level' string.
     */
    void displaySavingString(String p_73720_1_);

    /**
     * Displays a string on the loading screen supposed to indicate what is being done currently.
     */
    void displayLoadingString(String p_73719_1_);

    /**
     * Updates the progress bar on the loading screen to the specified amount. Args: loadProgress
     */
    void setLoadingProgress(int p_73718_1_);
}
