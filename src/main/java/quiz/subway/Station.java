package quiz.subway;

/**
 * Created by bollsal on 2016. 12. 6..
 */
public class Station {

    private Subway subway1;
    private Subway subway2;
    private Person person;

    public Station() {
        subway1 = new Subway(Subway.SUBWAY_01);
        subway2 = new Subway(Subway.SUBWAY_02);
    }

    public Subway getSubway(String route) {
        if (route.equals(Subway.SUBWAY_01)) {
            return subway1;
        } else {
            return subway2;
        }
    }

    public void enterPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    // 1호선에만 환승구간 있다고 가정
    public void setTransferPosition(int position) {
        subway1.setTransferPosition(position);
    }

    public void tick() {
        if (person != null) {
            Subway subway = getSubway(person.getCurrentRoute());
            subway.tick();

            if (subway.isTransferPosition() && !subway.getSubwayRoute().equals(person.getDestinationRoute())) {
                // 2호선으로만 환승된다고 가정.
                person.setCurrentInfo(subway2.getSubwayRoute(), subway2.getCurrentPosition());
            } else {
                person.setCurrentInfo(subway.getSubwayRoute(), subway.getCurrentPosition());
            }
        }
    }
}
