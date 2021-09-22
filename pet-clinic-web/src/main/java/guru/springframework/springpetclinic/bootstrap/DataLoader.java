package guru.springframework.springpetclinic.bootstrap;

import guru.springframework.springpetclinic.model.Owner;
import guru.springframework.springpetclinic.model.Pet;
import guru.springframework.springpetclinic.model.PetType;
import guru.springframework.springpetclinic.model.Vet;
import guru.springframework.springpetclinic.services.OwnerService;
import guru.springframework.springpetclinic.services.PetTypeService;
import guru.springframework.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

// spring boot specific way
@Component //this becomes a spring bean, and it is registered in the context
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {

		PetType dog = new PetType();
		dog.setName("Puppy");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		dog.setName("Kitty");
		PetType savedCatPetType = petTypeService.save(cat);

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("Street Whatever");
		owner1.setCity("Brasov");
		owner1.setTelephone("0726421283");

		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDay(LocalDate.now());
		mikesPet.setName("Maya");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("Street Whatever");
		owner2.setCity("Brasov");
		owner2.setTelephone("0726421223");

		Pet fionasPet = new Pet();
		fionasPet.setPetType(savedCatPetType);
		fionasPet.setOwner(owner2);
		fionasPet.setBirthDay(LocalDate.now());
		fionasPet.setName("Prutyi");

		ownerService.save(owner2);

		System.out.println("Loaded Owners....");


		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");

		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}
}
