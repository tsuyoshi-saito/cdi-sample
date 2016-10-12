package jp.co.mforce.samples;

import javax.enterprise.event.Observes;

import org.jboss.weld.exceptions.UnsupportedOperationException;

import jp.co.mforce.samples.quarifier.Insert;
import jp.co.mforce.samples.quarifier.Update;

public class UserEventListener {

	public void any1(@Observes User user) {
		System.out.println("Any1:" + user.getName());
		throw new UnsupportedOperationException("Any1 Exception");
	}

	public void any2(@Observes User user) {
		System.out.println("Any2:" + user.getName());
		throw new UnsupportedOperationException("Any2 Exception");
	}

	public void insert(@Observes @Insert User user) {
		System.out.println("Insert:" + user.getName());
	}

	public void update(@Observes @Update User user) {
		System.out.println("Update:" + user.getName());
	}
}
