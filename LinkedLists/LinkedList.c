#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

struct Node* head = NULL;

void insertBegin(int val){
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = val;
    newNode->next = head;
    head = newNode;
}

void insertEnd(int val){
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    struct Node* temp = head;

    newNode->data = val;
    newNode->next = NULL;

    if(head == NULL){
        head = newNode;
        return;
    }

    while(temp->next != NULL)
        temp = temp->next;

    temp->next = newNode;
}

void insertPos(int val, int pos){
    struct Node *newNode, *temp=head;
    int i;

    newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = val;

    for(i=1;i<pos-1;i++)
        temp=temp->next;

    newNode->next=temp->next;
    temp->next=newNode;
}

void deleteBegin(){
    struct Node* temp=head;

    if(head==NULL) return;

    head=head->next;
    free(temp);
}

void deleteEnd(){
    struct Node *temp=head,*prev;

    if(head==NULL) return;

    if(head->next==NULL){
        free(head);
        head=NULL;
        return;
    }

    while(temp->next!=NULL){
        prev=temp;
        temp=temp->next;
    }

    prev->next=NULL;
    free(temp);
}

void deletePos(int pos){
    struct Node *temp=head,*prev;
    int i;

    for(i=1;i<pos;i++){
        prev=temp;
        temp=temp->next;
    }

    prev->next=temp->next;
    free(temp);
}

void display(){
    struct Node* temp=head;

    while(temp!=NULL){
        printf("%d -> ",temp->data);
        temp=temp->next;
    }
    printf("NULL\n");
}

int main(){
    int ch,val,pos;

    while(1){
        printf("\n1.Insert Begin\n2.Insert End\n3.Insert Position\n");
        printf("4.Delete Begin\n5.Delete End\n6.Delete Position\n");
        printf("7.Display\n8.Exit\n");

        scanf("%d",&ch);

        switch(ch){

            case 1:
                printf("Enter value to insert at beginning: ");
                scanf("%d",&val);
                insertBegin(val);
                break;

            case 2:
                printf("Enter value to insert at end: ");
                scanf("%d",&val);
                insertEnd(val);
                break;

            case 3:
                printf("Enter value and position to insert: ");
                scanf("%d%d",&val,&pos);
                insertPos(val,pos);
                break;

            case 4:
                printf("Deleting from beginning...\n");
                deleteBegin();
                break;

            case 5:
                printf("Deleting from end...\n");
                deleteEnd();
                break;

            case 6:
                printf("Enter position to delete: ");
                scanf("%d",&pos);
                deletePos(pos);
                break;

            case 7:
                printf("Displaying list...\n");
                display();
                break;

            case 8:
                exit(0);
        }
    }
}