package src.edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.PiechartObserver;
import edu.umb.cs680.hw13.StockQuoteObservable;
import edu.umb.cs680.hw13.TableObserver;
import edu.umb.cs680.hw13.ThreeDObserver;

class StockQuoteObservableTest {

	@Test
	void dijaQuoteCheckInstance() {
		PiechartObserver PiechartObserver = new PiechartObserver();
		TableObserver TableObserver = new TableObserver();
		ThreeDObserver THREEDObserver = new ThreeDObserver();

		StockQuoteObservable djiaObserver = new StockQuoteObservable();
		djiaObserver.addObserver(PiechartObserver);
		djiaObserver.addObserver(TableObserver);
		djiaObserver.addObserver(THREEDObserver);
		djiaObserver.changeQuote("Harvey",65);
		djiaObserver.changeQuote("Specter",70);
	}
}

