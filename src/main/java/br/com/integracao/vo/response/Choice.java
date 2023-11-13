package br.com.integracao.vo.response;

import java.io.Serializable;
import java.util.Objects;

import br.com.integracao.messages.Message;

public class Choice implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int index;
	private Message message;
	
	public Choice() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(index, message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Choice other = (Choice) obj;
		return index == other.index && Objects.equals(message, other.message);
	}
	
	
}
