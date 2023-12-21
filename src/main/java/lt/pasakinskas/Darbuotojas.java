package lt.pasakinskas;

import javax.persistence.*;

@Entity
@Table(name = "darbuotojai")
public class Darbuotojas {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String vardas;
  private String pavarde;
  private int atlyginimas;

  public Darbuotojas(String vardas, String pavarde, int atlyginimas) {
    this.vardas = vardas;
    this.pavarde = pavarde;
    this.atlyginimas = atlyginimas;
  }

  @Override
  public String toString() {
    return "Darbuotojas{" +
      "id=" + id +
      ", vardas='" + vardas + '\'' +
      ", pavarde='" + pavarde + '\'' +
      ", atlyginimas=" + atlyginimas +
      '}';
  }

  public Darbuotojas() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getVardas() {
    return vardas;
  }

  public void setVardas(String vardas) {
    this.vardas = vardas;
  }

  public String getPavarde() {
    return pavarde;
  }

  public void setPavarde(String pavarde) {
    this.pavarde = pavarde;
  }

  public int getAtlyginimas() {
    return atlyginimas;
  }

  public void setAtlyginimas(int atlyginimas) {
    this.atlyginimas = atlyginimas;
  }
}
