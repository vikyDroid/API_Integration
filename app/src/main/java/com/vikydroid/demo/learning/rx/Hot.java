package com.vikydroid.demo.learning.rx;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

public class Hot {
    public static void main(String[] args) {
        Observable<Integer> cold = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Source emit " + i);
                    emitter.onNext(i);
                }
            }
        });

        ConnectableObservable<Integer> connectibleObservable = cold.publish();
        connectibleObservable.subscribe(/*pass th observer*/);
        connectibleObservable.connect();

        //Gives last computed value only
        AsyncSubject<Integer> asyncSubject = AsyncSubject.create();
        cold.subscribe(asyncSubject);
        asyncSubject.subscribe(/*pass th observer*/);

        //Gives default value or current value
        BehaviorSubject<Integer> behaviorSubject = BehaviorSubject.create();
        cold.subscribe(behaviorSubject);
        behaviorSubject.subscribe(/*pass th observer*/);

        PublishSubject<Integer> publishSubject;
        ReplaySubject<Integer> replaySubject;

    }
}

