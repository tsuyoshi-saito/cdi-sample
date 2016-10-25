package jp.co.mforce.samples;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import jp.co.mforce.samples.quarifier.Insert;
import jp.co.mforce.samples.quarifier.Update;

public class ObserversSample {

	@Inject
	Event<User> anyEvent;

	@Inject
	@Update
	Event<User> updateEvent;

	@Inject
	@Insert
	Event<User> insertEvent;

	@Inject
	@Insert
	@Update
	Event<User> insertOrUpdateEvent;

	public static void main(String[] args) {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		ObserversSample cdiSample = container.instance().select(ObserversSample.class).get();

		cdiSample.run();
	}

	public void run() {
		this.insertEvent.fire(new User().name("山田").age(30));
		this.updateEvent.fire(new User().name("鈴木").age(56));
		this.anyEvent.fire(new User().name("五十嵐").age(15));
		this.insertOrUpdateEvent.fire(new User().name("池田").age(15));
	}
}
