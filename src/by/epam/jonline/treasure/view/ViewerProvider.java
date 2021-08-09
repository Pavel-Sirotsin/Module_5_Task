package by.epam.jonline.treasure.view;

import by.epam.jonline.treasure.view.impl.CaveActionViewer;
import by.epam.jonline.treasure.view.impl.MainViewerImpl;

public class ViewerProvider {
	private static final ViewerProvider instance = new ViewerProvider();

	private ViewerProvider() {
	}

	private ICaveViewer caveViewer = new CaveActionViewer();
	private IMainViewer mainViewer = new MainViewerImpl();

	public ICaveViewer getCaveActionViewer() {
		return caveViewer;
	}

	public IMainViewer getMainViewerImpl() {
		return mainViewer;
	}

	public static ViewerProvider getInstance() {
		return instance;
	}

}
