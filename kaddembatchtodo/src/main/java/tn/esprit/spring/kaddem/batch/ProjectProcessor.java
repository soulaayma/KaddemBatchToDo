package tn.esprit.spring.kaddem.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;

@Slf4j
public class ProjectProcessor implements ItemProcessor<Equipe, Equipe> {
	/*12. logique métier de notre job*/
	@Override
	public Equipe process(Equipe equipe) {
		log.info("Start Batch Item Processor");
		for (Etudiant etudiant : equipe.getEtudiants() ) {
			etudiant.getContrats().forEach(contrat -> {
				contrat.setMontantContrat(contrat.getMontantContrat()+((contrat.getMontantContrat()*10)%100));
			});

		}
		return equipe;
	}
}
