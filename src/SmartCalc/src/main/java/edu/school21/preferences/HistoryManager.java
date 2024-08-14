package edu.school21.preferences;

import java.util.prefs.Preferences;

public class HistoryManager {

  private static final String HISTORY_KEY = "history";
  private Preferences prefs;

  public HistoryManager() {
    prefs = Preferences.userNodeForPackage(HistoryManager.class);
  }

  public void saveHistory(String history) {
    prefs.put(HISTORY_KEY, history);
  }

  public String loadHistory() {
    return prefs.get(HISTORY_KEY, "");
  }
}
