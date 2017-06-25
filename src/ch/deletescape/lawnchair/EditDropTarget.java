package ch.deletescape.lawnchair;

import android.content.Context;
import android.util.AttributeSet;

public class EditDropTarget extends ButtonDropTarget {

    public EditDropTarget(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EditDropTarget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        // Get the hover color
        mHoverColor = Utilities.getColorAccent(getContext());

        setDrawable(R.drawable.ic_info_launcher);
    }

    @Override
    protected boolean supportsDrop(DragSource source, ItemInfo info) {
        return info instanceof AppInfo;
    }

    @Override
    void completeDrop(final DragObject d) {
        new EditAppDialog(getContext(), ((AppInfo) d.dragInfo), mLauncher).show();
    }

}
