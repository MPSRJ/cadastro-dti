package br.mil.eb.caddti.tymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import br.mil.eb.caddti.tymeleaf.processor.ClassForErrorAttributeTagProcessor;
import br.mil.eb.caddti.tymeleaf.processor.MenuAttributeTagProcessor;
import br.mil.eb.caddti.tymeleaf.processor.MessageElementTagProcessor;
import br.mil.eb.caddti.tymeleaf.processor.OrderElementTagProcessor;
import br.mil.eb.caddti.tymeleaf.processor.PaginationElementTagProcessor;

public class MpsDialect extends AbstractProcessorDialect {

	public MpsDialect() {
		super("http://caddti.eb.mil.br", "mps", StandardDialect.PROCESSOR_PRECEDENCE);
	}
	
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		processadores.add(new OrderElementTagProcessor(dialectPrefix));
		processadores.add(new PaginationElementTagProcessor(dialectPrefix));
		processadores.add(new MenuAttributeTagProcessor(dialectPrefix));
		return processadores;
	}

}
