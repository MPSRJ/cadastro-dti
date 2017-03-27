package br.mil.eb.caddti.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import br.mil.eb.caddti.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import br.mil.eb.caddti.thymeleaf.processor.MenuAttributeTagProcessor;
import br.mil.eb.caddti.thymeleaf.processor.MessageElementTagProcessor;
import br.mil.eb.caddti.thymeleaf.processor.OrderElementTagProcessor;
import br.mil.eb.caddti.thymeleaf.processor.PaginationElementTagProcessor;

public class AppDialect extends AbstractProcessorDialect {

	public AppDialect() {
		super("APP", "app", StandardDialect.PROCESSOR_PRECEDENCE);
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
