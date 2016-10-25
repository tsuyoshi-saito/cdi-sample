package jp.co.mforce.samples;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;

import jp.co.mforce.samples.quarifier.Insert;
import jp.co.mforce.samples.quarifier.Update;

public class UserEventListener {

	public void nonAnotate(@Observes User user) {
		System.out.println("Non:\t" + user.getName());
	}
	
	public void any(@Observes @Any User user) {
		System.out.println("Any:\t" + user.getName());
	}

	public void insert(@Observes @Insert User user) {
		System.out.println("Insert:\t" + user.getName());
	}

	public void update(@Observes @Update User user) {
		System.out.println("Update:\t" + user.getName());
	}

	public void insertOrUpdate(@Observes @Insert @Update User user) {
		System.out.println("Upsert:\t" + user.getName());
	}
}
