package feedsClientApp.mbeans;

import feedsApp.entities.Feeds;

public class TempFeed {
	private Feeds feed;
	private boolean enitable;
	public Feeds getFeed() {
		return feed;
	}
	public void setFeed(Feeds feed) {
		this.feed = feed;
	}
	public boolean isEnitable() {
		return enitable;
	}
	public void setEnitable(boolean enitable) {
		this.enitable = enitable;
	}
}
