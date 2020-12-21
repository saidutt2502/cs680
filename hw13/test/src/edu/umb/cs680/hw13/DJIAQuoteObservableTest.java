package src.edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;

import edu.umb.cs680.hw13.DJIAQuoteObservable;
import edu.umb.cs680.hw13.PiechartObserver;
import edu.umb.cs680.hw13.StockQuoteObservable;
import edu.umb.cs680.hw13.TableObserver;
import edu.umb.cs680.hw13.ThreeDObserver;

import org.junit.jupiter.api.Test;


class DJIAQuoteObservableTest {

	@Test
	void checkDijaQuote() {
		PiechartObserver PiechartObserver = new PiechartObserver();
		TableObserver TableObserver = new TableObserver();
		ThreeDObserver THREEDObserver = new ThreeDObserver();

		DJIAQuoteObservable djiaObserver = new DJIAQuoteObservable();
		djiaObserver.addObserver(PiechartObserver);
		djiaObserver.addObserver(TableObserver);
		djiaObserver.addObserver(THREEDObserver);

		djiaObserver.changeQuote(65);
		djiaObserver.changeQuote(70);
	}
}
